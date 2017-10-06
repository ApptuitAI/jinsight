/*
 * Copyright 2017 Agilx, Inc.
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

package ai.apptuit.metrics.jinsight.modules.httpclient;

import ai.apptuit.metrics.dropwizard.TagEncodedMetricName;
import ai.apptuit.metrics.jinsight.modules.common.RuleHelper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.jboss.byteman.rule.Rule;

/**
 * @author Rajiv Shivane
 */
public class HttpClientRuleHelper extends RuleHelper {

  public static final TagEncodedMetricName ROOT_NAME = TagEncodedMetricName.decode("http.requests");
  private static final OperationId EXECUTE_METHOD_OPERATION_ID = new OperationId("ahc.execute");

  public HttpClientRuleHelper(Rule rule) {
    super(rule);
  }

  public void onExecuteStart(HttpRequest request) {
    beginTimedOperation(EXECUTE_METHOD_OPERATION_ID);
  }

  public void onExecuteEnd(HttpRequest request, HttpResponse response) {
    endTimedOperation(EXECUTE_METHOD_OPERATION_ID, () -> ROOT_NAME.withTags(
        "method", request.getRequestLine().getMethod(),
        "status", "" + response.getStatusLine().getStatusCode())
    );
  }
}
