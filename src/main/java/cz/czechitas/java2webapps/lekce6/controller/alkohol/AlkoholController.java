package cz.czechitas.java2webapps.lekce6.controller.alkohol;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import java.util.Random;

/**
 */
@Controller
@RequestMapping("/alkohol")
public class AlkoholController {
  private final Random random = new Random();

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/alkohol/formular");
    modelAndView.addObject("form", new AlkoholForm());
    return modelAndView;
  }

  @PostMapping("")
  public Object form(@Valid @ModelAttribute("form") AlkoholForm form, BindingResult bindingResult) { // validace

    if (form.getVek() < 18) {
      return "/alkohol/nizky-vek"; // error, kdy nelze prodat alkohol <18
    }


    if (bindingResult.hasErrors()) { // validace dopadla špatně, nechám uživatele opravit
      return "/alkohol/formular";
    }

    return new ModelAndView("/alkohol/objednano") // validace dopadla dobře, přesměruji uživatele na objednáno
            .addObject("kod", Math.abs(random.nextInt())) // náhodné číslo objednávky
            .addObject("email", form.getEmail()); // e-mail zadaný do formuláře
  }
}
