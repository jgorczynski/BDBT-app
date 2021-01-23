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
@RequestMapping("poczty")
public class PocztyController {

	@Autowired
	private PocztyDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		List<Poczty> listPoczty = dao.list();
		model.addAttribute("listUczelnie", listPoczty);
		return "index_post";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Poczty poczty = new Poczty();
		model.addAttribute("poczty", poczty);

		return "new_post";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("poczty") Poczty poczty) {
		dao.save(poczty);

		return "redirect:/poczty/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_post");
		Poczty poczty = dao.get(id);
		mav.addObject("poczty", poczty);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("poczty") Poczty poczty) {
		dao.update(poczty);

		return "redirect:/poczty/";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		dao.delete(id);
		return "redirect:/poczty/";
	}

}
