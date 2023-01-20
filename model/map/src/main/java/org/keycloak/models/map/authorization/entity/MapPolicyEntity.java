/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
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

package org.keycloak.models.map.authorization.entity;

import org.keycloak.models.map.annotations.GenerateEntityImplementations;
import org.keycloak.models.map.common.AbstractEntity;
import org.keycloak.models.map.common.DeepCloner;
import org.keycloak.models.map.common.UpdatableEntity;
import org.keycloak.representations.idm.authorization.DecisionStrategy;
import org.keycloak.representations.idm.authorization.Logic;

import java.util.Map;
import java.util.Set;

@GenerateEntityImplementations(
        inherits = "org.keycloak.models.map.authorization.entity.MapPolicyEntity.AbstractMapPolicyEntity"
)
@DeepCloner.Root
public interface MapPolicyEntity extends UpdatableEntity, AbstractEntity {

    public abstract class AbstractMapPolicyEntity extends UpdatableEntity.Impl implements MapPolicyEntity {

        private String id;

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public void setId(String id) {
            if (this.id != null) throw new IllegalStateException("Id cannot be changed");
            this.id = id;
            this.updated |= id != null;
        }
    }

    String getRealmId();
    void setRealmId(String realmId);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    String getType();
    void setType(String type);

    DecisionStrategy getDecisionStrategy();
    void setDecisionStrategy(DecisionStrategy decisionStrategy);

    Logic getLogic();
    void setLogic(Logic logic);

    Map<String, String> getConfigs();
    void setConfigs(Map<String, String> config);
    String getConfig(String name);
    void setConfig(String name, String value);
    void removeConfig(String name);

    String getResourceServerId();
    void setResourceServerId(String resourceServerId);

    Set<String> getAssociatedPolicyIds();
    void addAssociatedPolicyId(String policyId);
    void removeAssociatedPolicyId(String policyId);

    Set<String> getResourceIds();
    void addResourceId(String resourceId);
    void removeResourceId(String resourceId);

    Set<String> getScopeIds();
    void addScopeId(String scopeId);
    void removeScopeId(String scopeId);

    String getOwner();
    void setOwner(String owner);
}
