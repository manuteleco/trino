/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.spiller;

import io.airlift.configuration.Config;
import io.airlift.configuration.LegacyConfig;
import io.airlift.units.DataSize;
import jakarta.validation.constraints.NotNull;

public class NodeSpillConfig
{
    private DataSize maxSpillPerNode = DataSize.of(100, DataSize.Unit.GIGABYTE);
    private DataSize queryMaxSpillPerNode = DataSize.of(100, DataSize.Unit.GIGABYTE);

    private boolean spillCompressionEnabled;
    private boolean spillEncryptionEnabled;

    @NotNull
    public DataSize getMaxSpillPerNode()
    {
        return maxSpillPerNode;
    }

    @Config("max-spill-per-node")
    @LegacyConfig("experimental.max-spill-per-node")
    public NodeSpillConfig setMaxSpillPerNode(DataSize maxSpillPerNode)
    {
        this.maxSpillPerNode = maxSpillPerNode;
        return this;
    }

    @NotNull
    public DataSize getQueryMaxSpillPerNode()
    {
        return queryMaxSpillPerNode;
    }

    @Config("query-max-spill-per-node")
    @LegacyConfig("experimental.query-max-spill-per-node")
    public NodeSpillConfig setQueryMaxSpillPerNode(DataSize queryMaxSpillPerNode)
    {
        this.queryMaxSpillPerNode = queryMaxSpillPerNode;
        return this;
    }

    public boolean isSpillCompressionEnabled()
    {
        return spillCompressionEnabled;
    }

    @Config("spill-compression-enabled")
    @LegacyConfig("experimental.spill-compression-enabled")
    public NodeSpillConfig setSpillCompressionEnabled(boolean spillCompressionEnabled)
    {
        this.spillCompressionEnabled = spillCompressionEnabled;
        return this;
    }

    public boolean isSpillEncryptionEnabled()
    {
        return spillEncryptionEnabled;
    }

    @Config("spill-encryption-enabled")
    @LegacyConfig("experimental.spill-encryption-enabled")
    public NodeSpillConfig setSpillEncryptionEnabled(boolean spillEncryptionEnabled)
    {
        this.spillEncryptionEnabled = spillEncryptionEnabled;
        return this;
    }
}
