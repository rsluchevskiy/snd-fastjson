/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: VisibleForTesting.java
*    
*    Copyrights:
*      copyright (c) 2006 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Longs.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Shorts.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Ints.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Chars.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: UnsignedBytes.java
*    
*    Copyrights:
*      copyright (c) 2009 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: SignedBytes.java
*    
*    Copyrights:
*      copyright (c) 2009 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Bytes.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Floats.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Doubles.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Booleans.java
*    
*    Copyrights:
*      copyright (c) 2008 google inc
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    
*    Release: https://github.com/google/guava/releases/tag/v6.0
*    Source File: Primitives.java
*    
*    Copyrights:
*      copyright (c) 2007 google inc
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

public interface PropertyPreFilter extends SerializeFilter {

    boolean apply(JSONSerializer serializer, Object object, String name);
}
