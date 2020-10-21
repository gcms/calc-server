package br.edu.ifg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private static List<Produto> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(new Produto(1, "Liquidificador", "", 123));
        PRODUTOS.add(new Produto(2, "Máquina de Lavar", "", 1234));
    }

    @GetMapping("/")
    public String listar(ModelMap model) {
        model.put("produtoList", PRODUTOS);
        return "lista-produtos";
    }

    @GetMapping("/novo")
    public String novo() {
        return "novo-produto";
    }

    @PostMapping("/criar")
    public String criar(@RequestParam("nome") String nome, @RequestParam("preco") BigDecimal preco) {
        Produto novo = new Produto((int) (Math.random() * 1000), nome, "", preco);
        PRODUTOS.add(novo);

        return "redirect:/produtos/";
    }

    @GetMapping("/{id}")
    public ModelAndView obter(@PathVariable("id") int id) {
        Produto resultado = null;
        for (Produto p : PRODUTOS) {
            if (p.getId() == id) {
                resultado = p;
                break;
            }
        }

        return new ModelAndView("ver-produto", new ModelMap("produto", resultado));
    }

    @RequestMapping(value = "/excluir/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String excluir(@PathVariable("id") int id) {
        for (Produto p : PRODUTOS) {
            if (p.getId() == id) {
                PRODUTOS.remove(p);
                break;
            }
        }

        return "redirect:/produtos/";
    }
}
