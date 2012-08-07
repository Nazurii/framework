/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.tests.minitutorials.v7a1;

import com.vaadin.Application;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Root;

/**
 * Mini tutorial code for
 * https://vaadin.com/wiki/-/wiki/Main/Finding%20the%20current
 * %20Root%20and%20Application
 * 
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
public class FindCurrentRootAndApplication extends Root {

    @Override
    protected void init(WrappedRequest request) {
        Button helloButton = new Button("Say Hello");
        helloButton.addListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                String msg = "Running in ";
                msg += Application.getCurrent().isProductionMode() ? "production"
                        : "debug";
                Notification.show(msg);
            }
        });

        helloButton.addListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("This Root is "
                        + Root.getCurrent().getClass().getSimpleName());
            }
        });

        addComponent(helloButton);
    }

}
