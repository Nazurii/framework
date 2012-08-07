/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.terminal.gwt.client.ui;

import com.google.gwt.user.client.ui.AbstractImagePrototype;

public interface TreeImages extends com.google.gwt.user.client.ui.TreeImages {

    /**
     * An image indicating an open branch.
     * 
     * @return a prototype of this image
     * @gwt.resource com/vaadin/terminal/gwt/public/default/tree/img/expanded
     *               .png
     */
    @Override
    AbstractImagePrototype treeOpen();

    /**
     * An image indicating a closed branch.
     * 
     * @return a prototype of this image
     * @gwt.resource com/vaadin/terminal/gwt/public/default/tree/img/collapsed
     *               .png
     */
    @Override
    AbstractImagePrototype treeClosed();

}
