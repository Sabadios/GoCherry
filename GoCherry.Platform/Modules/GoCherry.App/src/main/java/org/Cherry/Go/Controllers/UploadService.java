/*******************************************************************************
 * Copyright (c) 2013-2014 Cherry Platform
 *
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL
 * 1.0 (the "Licenses"). You can select the license that you prefer but you may
 * not use this file except in compliance with one of these Licenses.
 *
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 *
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0
 *
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1
 *
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1
 *
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 *
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 *
 *
 * Cherry Platform is a registered trademark of Sabadios
 *
 * Contributors:
 * Cristian Malinescu - initial design, API and implementation
 *******************************************************************************/
package org.Cherry.Go.Controllers;

import static org.Cherry.Modules.Web.WebConstants.URI_TOKEN;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.Cherry.Core.ServiceTemplate;

/**
 * @author Cristian.Malinescu
 * 
 */
@Singleton
@Path(value = AgentURI.Upload.BASE_URI)
@NotThreadSafe
public final class UploadService extends ServiceTemplate {
  @Path(value = URI_TOKEN)
  @Produces(MediaType.TEXT_HTML)
  public Map<?, ?> get() {
    final Map<String, Date> dateTimeNow = new HashMap<String, Date>();

    dateTimeNow.put("dateTimeNow", new Date());

    return dateTimeNow;
  }

  @PostConstruct
  protected void postConstruct() {
  }

  @PreDestroy
  protected void preDestroy() {
  }

  public UploadService() {
  }

  private static final long serialVersionUID = 1L;
}
