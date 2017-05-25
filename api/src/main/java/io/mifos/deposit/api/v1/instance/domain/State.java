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
package io.mifos.deposit.api.v1.instance.domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class State {

  @NotNull
  private Value value;
  private String note;
  private String createdBy;
  private LocalDateTime createdOn;
  public State() {
    super();
  }

  public String getValue() {
    return this.value.name();
  }

  public void setValue(final String value) {
    this.value = Value.valueOf(value);
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(final String note) {
    this.note = note;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedOn() {
    return this.createdOn;
  }

  public void setCreatedOn(final LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public enum Value {
    PENDING,
    OPEN,
    LOCKED,
    CLOSED
  }
}
