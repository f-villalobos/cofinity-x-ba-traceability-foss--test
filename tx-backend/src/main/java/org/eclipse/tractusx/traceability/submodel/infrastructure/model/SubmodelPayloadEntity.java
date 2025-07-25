/********************************************************************************
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/
package org.eclipse.tractusx.traceability.submodel.infrastructure.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eclipse.tractusx.traceability.assets.infrastructure.asbuilt.model.AssetAsBuiltEntity;
import org.eclipse.tractusx.traceability.assets.infrastructure.asplanned.model.AssetAsPlannedEntity;

import java.util.List;

@Entity
@Table(name = "submodel_payload")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmodelPayloadEntity {
    @Id
    private String id;

    private String json;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "assets_as_built_submodel_payload",
            joinColumns = @JoinColumn(name = "submodel_payload_id"),
            inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    public List<AssetAsBuiltEntity> assets;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "assets_as_planned_submodel_payload",
            joinColumns = @JoinColumn(name = "submodel_payload_id"),
            inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private List<AssetAsPlannedEntity> assetsAsPlanned;
}
