/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.server.redis.profiles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.debezium.server.redis.lifecyclemanagers.RedisTestResourceLifecycleManager;
import io.debezium.testing.testcontainers.PostgresTestResourceLifecycleManager;

public class RedisStreamMessageTestProfile extends RedisStreamTestProfile {
    @Override
    public List<TestResourceEntry> testResources() {
        return Arrays.asList(
                new TestResourceEntry(PostgresTestResourceLifecycleManager.class),
                new TestResourceEntry(RedisTestResourceLifecycleManager.class));
    }

    @Override
    public Map<String, String> getConfigOverrides() {
        Map<String, String> config = super.getConfigOverrides();
        config.put("debezium.sink.redis.message.format", "extended");
        return config;
    }

}
