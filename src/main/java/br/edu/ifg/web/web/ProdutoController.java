package br.edu.ifg.web.web;

import br.edu.ifg.web.service.Produto;
import br.edu.ifg.web.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @GetMapping("/")
    public String listar(ModelMap model) {
        model.put("produtoList", service.listar());
        return "lista-produtos";
    }

    @GetMapping("/novo")
    public String novo() {
        return "novo-produto";
    }

    @PostMapping("/criar")
    public String criar(@RequestParam("nome") String nome, @RequestParam("preco") BigDecimal preco) {
        Produto novo = new Produto(nome, "", preco);
        service.criar(novo);

        return "redirect:/produtos/";
    }

    @GetMapping("/{id}")
    public ModelAndView obter(@PathVariable("id") int id) {
        Produto resultado = service.obter(id);

        return new ModelAndView("ver-produto", new ModelMap("produto", resultado));
    }

    @RequestMapping(value = "/excluir/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String excluir(@PathVariable("id") int id) {
        service.excluir(id);
        return "redirect:/produtos/";
    }
}
