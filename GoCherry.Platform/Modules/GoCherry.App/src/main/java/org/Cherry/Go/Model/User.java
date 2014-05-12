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
package org.Cherry.Go.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Cristian.Malinescu
 * 
 */
public class User implements Serializable {
  public String getId() {
    return _id;
  }

  public void setId(final String id) {
    assert null != id && 8 <= id.trim().length();
    _id = id;
  }

  public String getParole() {
    return _parole;
  }

  public void setParole(final String parole) {
    assert null != parole && 8 <= parole.trim().length();
    _parole = parole;
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other)
      return true;

    if (other instanceof User) {
      final User that = (User) other;
      return getId().equals(that.getId());
    }

    return false;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{User:{");
    sb.append("'id':'").append(getId()).append("', 'parole':'").append(getParole()).append("'");

    sb.append("}}");

    return sb.toString();
  }

  @JsonProperty("id")
  private String _id;

  @JsonProperty("parole")
  private String _parole;

  public User(final String id, final String parole) {
    setId(id);
    setParole(parole);
  }

  public User() {
  }

  private static final long serialVersionUID = 1L;
}
