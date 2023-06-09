/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.common.inject.spi;

import java.util.Set;

/**
 * Implemented by {@link org.opensearch.common.inject.Binding bindings}, {@link org.opensearch.common.inject.Provider
 * providers} and instances that expose their dependencies explicitly.
 *
 * @author jessewilson@google.com (Jesse Wilson)
 * @since 2.0
 */
public interface HasDependencies {

    /**
     * Returns the known dependencies for this type. If this has dependencies whose values are not
     * known statically, a dependency for the {@link org.opensearch.common.inject.Injector Injector} will be
     * included in the returned set.
     *
     * @return a possibly empty set
     */
    Set<Dependency<?>> getDependencies();
}
