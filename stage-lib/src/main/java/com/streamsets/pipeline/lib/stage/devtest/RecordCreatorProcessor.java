/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.lib.stage.devtest;

import com.streamsets.pipeline.api.*;
import com.streamsets.pipeline.api.base.SingleLaneProcessor;

import java.util.Iterator;

@GenerateResourceBundle
@StageDef(version = "1.0.0", label = "Record Creator",
          description = "It creates 2 records from each original record")
public class RecordCreatorProcessor extends SingleLaneProcessor {

  @Override
  public void process(Batch batch, SingleLaneBatchMaker batchMaker) throws
      StageException {
    Iterator<Record> it = batch.getRecords();
    while (it.hasNext()) {
      Record record = it.next();
      Record record1 = getContext().cloneRecord(record);
      Record record2 = getContext().cloneRecord(record);
      record1.getHeader().setAttribute("expanded", "1");
      record2.getHeader().setAttribute("expanded", "2");
      batchMaker.addRecord(record1);
      batchMaker.addRecord(record2);
    }
  }

}
