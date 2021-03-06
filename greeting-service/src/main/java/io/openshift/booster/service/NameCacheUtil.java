/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
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

package io.openshift.booster.service;

import org.infinispan.commons.api.BasicCache;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import static io.openshift.booster.CacheConstants.NAME_CACHE_ID;

/**
 * Provides utility methods relating to the name cache
 */
@Component
public class NameCacheUtil {

    private final Cache springCache;
    private final BasicCache<String, String> infispanCache;

    public NameCacheUtil(CacheManager cacheManager) {
        springCache = cacheManager.getCache(NAME_CACHE_ID);
        infispanCache = (BasicCache<String, String>) springCache.getNativeCache();
    }

    /**
     * Clears all entries found in nameCache
     */
    public void clear() {
        springCache.clear();
    }

    public boolean isEmpty() {
        return infispanCache.isEmpty();
    }
}
