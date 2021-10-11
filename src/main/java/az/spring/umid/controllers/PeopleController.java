package az.spring.umid.controllers;

import az.spring.umid.dao.PersonDAO;
import az.spring.umid.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    PeopleController(PersonDAO personDAO){
        this.personDAO=personDAO;
    }

    @GetMapping()
    public String getList(Model model) {
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("person", personDAO.show(id));

        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }

}
