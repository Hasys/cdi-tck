/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.cdi.tck.tests.event.observer.resolve.enterprise;

import javax.ejb.Stateful;
import javax.enterprise.event.Observes;

@Stateful
public class Spitz implements LocalInterface, RemoteInterface {

    static boolean localNotified = false;
    static boolean remoteNotified = false;
    static boolean staticallyNotified = false;

    public void observeLocal(@Observes EJBEvent someEvent) {
        localNotified = true;
    }

    public void observeRemote(@Observes EJBEvent someEvent) {
        remoteNotified = true;
    }

    public static void staticallyObserveEvent(@Observes EJBEvent someEvent) {
        staticallyNotified = true;
    }
}
