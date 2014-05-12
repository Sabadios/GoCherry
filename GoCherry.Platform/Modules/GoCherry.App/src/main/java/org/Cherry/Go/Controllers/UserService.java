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

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.Cherry.Core.ServiceTemplate;
import org.Cherry.Go.Model.User;
import org.Cherry.Go.Model.Users;
import org.Cherry.Modules.Hazelcast.Middleware.HazelcastService;
import org.Cherry.Modules.Mongo.Middleware.MongoRepositoryService;
import org.Cherry.Modules.Web.Engine.Context;
import org.Cherry.Modules.Web.Engine.InvocationContext;
import org.Cherry.Modules.Web.Engine.SessionManager;
import org.apache.http.HttpRequest;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * @author Cristian.Malinescu
 * 
 */
@Singleton
@Path(value = "/user")
public final class UserService extends ServiceTemplate {
  @Path(value = ROOT_URI)
  @Produces(MediaType.TEXT_HTML)
  public Map<?, ?> get() {
    final HttpRequest request = Context.getInvocationContext().get(InvocationContext.Key.Request);

    debug("Invoked by [{}]", request);

    return Collections.emptyMap();
  }

  @Path(value = "/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Object save(@BeanParam final User user) {
    final HttpRequest request = Context.getInvocationContext().get(InvocationContext.Key.Request);

    debug("Invoked by [{}] with bean parameter [{}]", request, user);

    final User updatedUser = new User(null != user ? user.getId() : "<--null-->", (null != user ? user.getParole() : "<--null-->") + "*");

    return updatedUser;
  }

  @Path(value = "/users")
  @Produces(MediaType.APPLICATION_JSON)
  public Users users() {
    final HttpRequest request = Context.getInvocationContext().get(InvocationContext.Key.Request);

    debug("Invoked by [{}]", request);

    final Set<User> data = new HashSet<User>();

    data.add(new User("abcdefghij", "ABCD1234$%"));

    final Users users = new Users(data);

    return users;
  }

  private SessionManager getSessionManager() {
    assert null != _sessionManager;
    return _sessionManager;
  }

  private MongoRepositoryService getMongoRepository() {
    assert null != _mongoRepository;
    return _mongoRepository;
  }

  private HazelcastService getHazelcastService() {
    assert null != _hazelcastService;
    return _hazelcastService;
  }

  @Inject
  @Singleton
  private SessionManager _sessionManager;

  @Inject
  @Singleton
  private MongoRepositoryService _mongoRepository;

  @Inject
  @Singleton
  private HazelcastService _hazelcastService;

  @PostConstruct
  protected void postConstruct() {
  }

  void containerInitialized(@Observes final ContainerInitialized event) {
    info("CDI container initialialization completed - notification [{}] received.", event);

    info("Attached to service dependency : [{}]", getSessionManager());
    info("Attached to service dependency : [{}]", getMongoRepository());
    info("Attached to service dependency : [{}]", getHazelcastService());
  }

  @PreDestroy
  protected void preDestroy() {
  }

  public UserService() {
  }

  private static final long serialVersionUID = 1L;
}
