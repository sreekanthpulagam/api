/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.ws.rs.client;

import java.util.concurrent.Future;

import javax.ws.rs.core.GenericType;

/**
 * Callback that you can register that will execute onComplete() when a client response is ready for processing.
 *
 * @param <Response> response type
 *
 * @author Marek Potociar
 * @since 2.0
 */
public interface InvocationCallback<Response> {

    /**
     * Get the class of the instance to receive for
     * {@link #onComplete(java.util.concurrent.Future) }.
     *
     * @return the class of the response.
     */
    Class<Response> getType();

    /**
     * Get the generic type declaring the Java type of the instance to
     * receive for {@link #onComplete(java.util.concurrent.Future) }.
     *
     * @return the generic type of the response. If null then the method
     *         {@link #getType() } must not return null. Otherwise, if not null,
     *         the type information declared by the generic type takes
     *         precedence over the value returned by {@link #getType() }.
     */
    GenericType<Response> getGenericType();

    /**
     * TODO javadoc.
     *
     * @param future TODO.
     */
    public void onComplete(Future<Response> future);
}
