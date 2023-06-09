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
 *    http://www.apache.org/licenses/LICENSE-2.0
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

package org.opensearch.search.profile.aggregation;

import org.apache.lucene.search.Scorable;
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.search.profile.Timer;

import java.io.IOException;

public class ProfilingLeafBucketCollector extends LeafBucketCollector {

    private LeafBucketCollector delegate;
    private Timer collectTimer;

    public ProfilingLeafBucketCollector(LeafBucketCollector delegate, AggregationProfileBreakdown profileBreakdown) {
        this.delegate = delegate;
        this.collectTimer = profileBreakdown.getTimer(AggregationTimingType.COLLECT);
    }

    @Override
    public void collect(int doc, long bucket) throws IOException {
        collectTimer.start();
        try {
            delegate.collect(doc, bucket);
        } finally {
            collectTimer.stop();
        }
    }

    @Override
    public void setScorer(Scorable scorer) throws IOException {
        delegate.setScorer(scorer);
    }

}
