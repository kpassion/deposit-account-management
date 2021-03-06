/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.deposit.service.internal.mapper;

import io.mifos.core.api.util.UserContextHolder;
import io.mifos.core.lang.DateConverter;
import io.mifos.deposit.api.v1.definition.domain.DividendDistribution;
import io.mifos.deposit.service.internal.repository.DividendDistributionEntity;
import io.mifos.deposit.service.internal.repository.ProductDefinitionEntity;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;

public class DividendDistributionMapper {

  private DividendDistributionMapper() {
    super();
  }

  public static DividendDistributionEntity map(final DividendDistribution dividendDistribution,
                                               final ProductDefinitionEntity productDefinitionEntity) {
    final DividendDistributionEntity dividendDistributionEntity = new DividendDistributionEntity();

    dividendDistributionEntity.setProductDefinition(productDefinitionEntity);
    final Date dueDate = Date.valueOf(DateConverter.dateFromIsoString(dividendDistribution.getDueDate()));
    dividendDistributionEntity.setDueDate(dueDate);
    dividendDistributionEntity.setRate(Double.valueOf(dividendDistribution.getDividendRate()));
    dividendDistributionEntity.setCreatedOn(LocalDateTime.now(Clock.systemUTC()));
    dividendDistributionEntity.setCreatedBy(UserContextHolder.checkedGetUser());

    return dividendDistributionEntity;
  }

  public static DividendDistribution map(final DividendDistributionEntity dividendDistributionEntity) {
    final DividendDistribution dividendDistribution = new DividendDistribution();

    dividendDistribution.setDividendRate(dividendDistributionEntity.getRate().toString());
    dividendDistribution.setDueDate(DateConverter.toIsoString(dividendDistributionEntity.getDueDate().toLocalDate()));

    return dividendDistribution;
  }
}
