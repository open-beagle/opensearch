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

package org.opensearch.cluster;

import org.opensearch.cluster.metadata.Metadata;

/**
 * Interface to allow merging {@link org.opensearch.cluster.metadata.Metadata.Custom}.
 * When multiple Mergable Custom metadata of the same type are found (from underlying clusters), the
 * Custom metadata can be merged using {@link #merge(Metadata.Custom)}.
 *
 * @param <T> type of custom meta data
 */
public interface MergableCustomMetadata<T extends Metadata.Custom> {

    /**
     * Merges this custom metadata with other, returning either this or <code>other</code> custom metadata.
     * This method should not mutate either <code>this</code> or the <code>other</code> custom metadata.
     *
     * @param other custom meta data
     * @return the same instance or <code>other</code> custom metadata based on implementation
     *         if both the instances are considered equal, implementations should return this
     *         instance to avoid redundant cluster state changes.
     */
    T merge(T other);
}
