package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("uczelnie")
public class UczelnieController {

	@Autowired
	private UczelnieDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		List<Uczelnie> listUczelnie = dao.list();
		model.addAttribute("listUczelnie", listUczelnie);
		return "index_uni";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Uczelnie uczelnie = new Uczelnie();
		model.addAttribute("uczelnie", uczelnie);

		return "new_uni";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uczelnie") Uczelnie uczelnie) {
		dao.save(uczelnie);

		return "redirect:/uczelnie/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_uni");
		Uczelnie uczelnie = dao.get(id);
		mav.addObject("uczelnie", uczelnie);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("uczelnie") Uczelnie uczelnie) {
		dao.update(uczelnie);

		return "redirect:/uczelnie/";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		dao.delete(id);
		return "redirect:/uczelnie/";
	}

}
