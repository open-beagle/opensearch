/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.common.lucene;

import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;

public class BytesRefs {

    /**
     * Converts a value to a string, taking special care if its a {@link BytesRef} to call
     * {@link org.apache.lucene.util.BytesRef#utf8ToString()}.
     */
    public static String toString(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BytesRef) {
            return ((BytesRef) value).utf8ToString();
        }
        return value.toString();
    }

    /**
     * Converts an object value to BytesRef.
     */
    public static BytesRef toBytesRef(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BytesRef) {
            return (BytesRef) value;
        }
        return new BytesRef(value.toString());
    }

    public static BytesRef toBytesRef(Object value, BytesRefBuilder spare) {
        if (value == null) {
            return null;
        }
        if (value instanceof BytesRef) {
            return (BytesRef) value;
        }
        spare.copyChars(value.toString());
        return spare.get();
    }
}
