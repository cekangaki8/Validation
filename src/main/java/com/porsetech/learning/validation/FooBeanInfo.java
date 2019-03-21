package com.porsetech.learning.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

public class FooBeanInfo extends SimpleBeanInfo {

    public PropertyDescriptor[] getPropertyDescriptors() {

        try {
            final PropertyEditor stringTrimmerEditor = new StringTrimmerEditor(true);
            stringTrimmerEditor.setAsText("Candy");

        PropertyDescriptor ageDescriptor = new PropertyDescriptor("email", Foo.class) {
            public PropertyEditor createPropertyEditor(Object bean) {
                return stringTrimmerEditor;
            };
        };
        return new PropertyDescriptor[] { ageDescriptor };
        }
        catch (IntrospectionException ex) {
            throw new Error(ex.toString());
        }

    }
}
