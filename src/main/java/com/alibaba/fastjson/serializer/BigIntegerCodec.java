/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://spring.io/projects/spring-boot
*    Release: https://github.com/spring-projects/spring-boot/releases/tag/v3.0.0
*    Source File: OnBeanCondition.java
*    
*    Copyrights:
*      copyright 2012-2022 the original author or authors
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
/*
 * Copyright 1999-2018 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * @author wenshao[szujobs@hotmail.com]
 */
public class BigIntegerCodec implements ObjectSerializer, ObjectDeserializer {
    private final static BigInteger LOW = BigInteger.valueOf(-9007199254740991L);
    private final static BigInteger HIGH = BigInteger.valueOf(9007199254740991L);

    public final static BigIntegerCodec instance = new BigIntegerCodec();

    public void write(JSONSerializer serializer
            , Object object
            , Object fieldName
            , Type fieldType, int features) throws IOException
    {
        SerializeWriter out = serializer.out;

        if (object == null) {
            out.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        
        BigInteger val = (BigInteger) object;
        String str = val.toString();
        if (str.length() >= 16
                && SerializerFeature.isEnabled(features, out.features, SerializerFeature.BrowserCompatible)
                && (val.compareTo(LOW) < 0
                    || val.compareTo(HIGH) > 0))
        {
            out.writeString(str);
            return;
        }
        out.write(str);
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        return (T) deserialze(parser);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialze(DefaultJSONParser parser) {
        final JSONLexer lexer = parser.lexer;
        if (lexer.token() == JSONToken.LITERAL_INT) {
            String val = lexer.numberString();
            lexer.nextToken(JSONToken.COMMA);

            if (val.length() > 65535) {
                throw new JSONException("decimal overflow");
            }

            return (T) new BigInteger(val);
        }

        Object value = parser.parse();
        return value == null //
            ? null //
            : (T) TypeUtils.castToBigInteger(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
