/*
 * Copyright  2002-2006 WYMIWYG (http://wymiwyg.org)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.wymiwyg.wrhapi.osgi;

import java.util.logging.Logger;
import org.osgi.service.http.HttpService;
import org.wymiwyg.wrhapi.WebServer;

/**
 * @author reto
 *
 */
public class OsgiWebServer implements WebServer {

	private final static Logger log = Logger.getLogger(OsgiWebServer.class.getName());
	private final String alias;
	private final HttpService httpService;

	OsgiWebServer(HttpService httpService, String alias) {
		this.httpService = httpService;
		this.alias = alias;
	}

	/* (non-Javadoc)
	 * @see org.wymiwyg.wrhapi.WebServer#stop()
	 */
	public void stop() {
		httpService.unregister(alias);
	}
}
