/*
 * Copyright (c) 2007 Stiftung Deutsches Elektronen-Synchrotron,
 * Member of the Helmholtz Association, (DESY), HAMBURG, GERMANY.
 *
 * THIS SOFTWARE IS PROVIDED UNDER THIS LICENSE ON AN "../AS IS" BASIS.
 * WITHOUT WARRANTY OF ANY KIND, EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE. SHOULD THE SOFTWARE PROVE DEFECTIVE
 * IN ANY RESPECT, THE USER ASSUMES THE COST OF ANY NECESSARY SERVICING, REPAIR OR
 * CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE.
 * NO USE OF ANY SOFTWARE IS AUTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.
 * DESY HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS,
 * OR MODIFICATIONS.
 * THE FULL LICENSE SPECIFYING FOR THE SOFTWARE THE REDISTRIBUTION, MODIFICATION,
 * USAGE AND OTHER RIGHTS AND OBLIGATIONS IS INCLUDED WITH THE DISTRIBUTION OF THIS
 * PROJECT IN THE FILE LICENSE.HTML. IF THE LICENSE IS NOT INCLUDED YOU MAY FIND A COPY
 * AT HTTP://WWW.DESY.DE/LEGAL/LICENSE.HTM
 */
/*
 * $Id$
 */
package org.csstudio.utility.ldap.preference;

import javax.annotation.Nonnull;
import javax.naming.Context;

/**
 * Preference keys.
 *
 * @author bknerr
 * @version $Revision$
 * @since 30.03.2010
 */
public enum PreferenceKey {
    P_STRING_USER_PASSWORD(Context.SECURITY_CREDENTIALS),
    P_STRING_USER_DN(Context.SECURITY_PRINCIPAL),
    SECURITY_PROTOCOL(Context.SECURITY_PROTOCOL),
    SECURITY_AUTHENTICATION(Context.SECURITY_AUTHENTICATION),
    P_STRING_URL(Context.PROVIDER_URL);

    private final String _contextId;


    /**
     * Constructor.
     * Known eclipse bug with annotations in enum constructor:
     * {@link https://bugs.eclipse.org/bugs/show_bug.cgi?id=285701}
     * @param contextId the corresponding value from the Context interface
     */
    //CHECKSTYLE:OFF
    private PreferenceKey(final String contextId) {
    //CHECKSTYLE:ON
        _contextId = contextId;
    }

    /**
     * The corresponding LDAP context id of this property.
     * @return the context id
     */
    @Nonnull
    public String getContextId() {
        return _contextId;
    }
}
