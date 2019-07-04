package com.porsetech.learning.validation;


import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
public class FooController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/foo", method = RequestMethod.POST)
    public Foo foo(@RequestBody @Validated Foo foo) {
        return foo;
    }

    @RequestMapping(value = "/fooRequest", method = RequestMethod.POST)
    public Foo fooRequest(@ModelAttribute("foo") Foo foo, BindingResult bindingResult, Model model) {
        return foo;
    }


}
