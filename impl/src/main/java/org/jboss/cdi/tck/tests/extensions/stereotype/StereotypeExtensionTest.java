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
package org.jboss.cdi.tck.tests.extensions.stereotype;

import static org.jboss.cdi.tck.cdi.Sections.BBD;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import javax.enterprise.inject.spi.Bean;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.cdi.tck.AbstractTest;
import org.jboss.cdi.tck.shrinkwrap.WebArchiveBuilder;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * Tests that stereotype registered via the SPI works correctly.
 *
 * @author Martin Kouba
 */
@SpecVersion(spec = "cdi", version = "1.1 Final Release")
public class StereotypeExtensionTest extends AbstractTest {

    @Deployment
    public static WebArchive createTestArchive() {

        return new WebArchiveBuilder().withTestClassPackage(StereotypeExtensionTest.class)
                .withExtension(StereotypeExtension.class).build();
    }

    @Test
    @SpecAssertion(section = BBD, id = "ad")
    public void testStereotypeWorks() {

        Bean<Chair> chairBean = getUniqueBean(Chair.class);
        assertEquals(chairBean.getName(), "chair");

        Chair instance = getContextualReference("chair", Chair.class);
        assertNotNull(instance);
        assertEquals(instance.breakUpToPieces(), 5);
    }

}
