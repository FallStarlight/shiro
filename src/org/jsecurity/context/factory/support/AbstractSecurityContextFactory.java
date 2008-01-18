/*
* Copyright (C) 2005-2007 Les Hazlewood, Jeremy Haile
*
* This library is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as published
* by the Free Software Foundation; either version 2.1 of the License, or
* (at your option) any later version.
*
* This library is distributed in the hope that it will be useful, but
* WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
* or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
* Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this library; if not, write to the
*
* Free Software Foundation, Inc.
* 59 Temple Place, Suite 330
* Boston, MA 02111-1307
* USA
*
* Or, you may view it online at
* http://www.opensource.org/licenses/lgpl-license.php
*/
package org.jsecurity.context.factory.support;

import org.jsecurity.authc.Account;
import org.jsecurity.authc.AuthenticationToken;
import org.jsecurity.context.SecurityContext;
import org.jsecurity.context.factory.SecurityContextFactory;

import java.util.Collection;

/**
 * Abstract implementation of the <tt>SecurityContextFactory</tt> interface that
 * ensures the given <tt>Account</tt> is valid.
 *
 * @since 0.1
 * @author Les Hazlewood
 * @author Jeremy Haile
 */
public abstract class AbstractSecurityContextFactory
    implements SecurityContextFactory {

    public AbstractSecurityContextFactory(){}

    public SecurityContext createSecurityContext( AuthenticationToken token, Account account ) {
        Collection principals = account.getPrincipals();
        if ( principals == null || principals.size() < 1 ) {
            String msg = "Account parameter must return at least one, non-null principal.";
            throw new IllegalArgumentException( msg );
        }
        return onCreateSecurityContext( token, account );
    }

    protected abstract SecurityContext onCreateSecurityContext( AuthenticationToken token, Account account );

}
