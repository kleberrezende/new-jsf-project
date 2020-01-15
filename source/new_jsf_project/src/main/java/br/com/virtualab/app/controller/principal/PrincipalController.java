package br.com.virtualab.app.controller.principal;

import br.com.virtualab.app.entity.configuracoes.Configuracoes;
import br.com.virtualab.app.service.configuracoes.ConfiguracoesFactory;
import br.com.virtualab.app.service.menu.MenuFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PrincipalController extends AbstractPrincipalController {

    private static final long serialVersionUID = 1L;

    private final String descricaoEmpresa = "Virtua Lab";
    private final String descricaoSistema = "new_project";
    private Configuracoes configuracoes = new Configuracoes();

    @Autowired
    private ConfiguracoesFactory configuracoesFactory;

    @Autowired
    private MenuFactory menuFactory;

    @Override
    public void carregarInicializar() {
        this.configuracoes = configuracoesFactory.buscarConfiguracoesPorId(Long.valueOf(1));
        if (configuracoes == null) {
            configuracoes = new Configuracoes();
        }
        configTemaSistema();
        setMenuGrupos(menuFactory.inicializarMenu());
        inicializarFavoritos();
    }

    private void configTemaSistema() {
        if (configuracoes.getTemaSistema() == null) {
            configuracoes.setTemaSistema("aristo");
        }
        setTemaSistema(configuracoes.getTemaSistema());
    }

    public Configuracoes getConfiguracoes() {
        return configuracoes;
    }

    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    public String getDescricaoSistema() {
        return descricaoSistema;
    }

}
