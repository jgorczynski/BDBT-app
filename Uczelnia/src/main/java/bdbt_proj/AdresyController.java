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
@RequestMapping("adresy")
public class AdresyController {

	@Autowired
	private AdresyDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		List<Adresy> listAdresy = dao.list();
		model.addAttribute("listAdresy", listAdresy);
		return "index_address";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Adresy adresy = new Adresy();
		model.addAttribute("adresy", adresy);

		return "new_address";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("adresy") Adresy adresy) {
		dao.save(adresy);

		return "redirect:/adresy/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_address");
		Adresy adresy = dao.get(id);
		mav.addObject("adresy", adresy);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("adresy") Adresy adresy) {
		dao.update(adresy);

		return "redirect:/adresy/";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		dao.delete(id);
		return "redirect:/adresy/";
	}

}
