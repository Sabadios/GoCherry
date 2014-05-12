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

import static org.Cherry.Modules.Web.WebConstants.ROOT_URI;

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
@Path(value = ROOT_URI)
@NotThreadSafe
public final class IndexService extends ServiceTemplate {
  @Path(value = ROOT_URI)
  @Produces(MediaType.TEXT_HTML)
  public Map<?, ?> get() {
    debug("'get()' Invoked by [{}]", Thread.currentThread());

    final Map<String, Date> dateTimeNow = new HashMap<String, Date>();

    dateTimeNow.put("dateTimeNow", new Date());

    return dateTimeNow;
  }

  @Path(value = "/timeStamp")
  @Produces(MediaType.APPLICATION_JSON)
  public String timeStamp() {
    return "";
  }

  @PostConstruct
  protected void postConstruct() {
    info("Instance [{}] 'postConstruct' signal received.", this);
  }

  @PreDestroy
  protected void preDestroy() {
    info("Instance [{}] 'preDestroy' signal received.", this);
  }

  public IndexService() {
  }

  private static final long serialVersionUID = 1L;
}
