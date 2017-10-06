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

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author Rajiv Shivane
 */
public class DefaultHttpClientInstrumentationTest extends HttpClientInstrumentationTest {

  @Override
  protected HttpClient createClient() {
    HttpClient httpclient;
    httpclient = HttpClients.createDefault();
    /*
    httpclient = HttpClients.createMinimal();
    httpclient = HttpClientBuilder.create().build();
    httpclient = new DefaultHttpClient();
    httpclient = new DecompressingHttpClient(new DefaultHttpClient())


    HttpRequestExecutor executor = new HttpRequestExecutor();
    executor.preProcess(request, processor, context);
    HttpResponse response = executor.execute(request, connection, context);
    executor.postProcess(response, processor, context);

    */

    return httpclient;
  }
}
