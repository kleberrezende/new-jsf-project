package br.com.virtualab.app.controller.configuracoes;

import br.com.virtualab.app.controller.Abstract.AbstractController;
import br.com.virtualab.app.controller.principal.PrincipalController;
import br.com.virtualab.app.entity.configuracoes.Configuracoes;
import br.com.virtualab.app.permissoes.Permissoes;
import br.com.virtualab.app.service.configuracoes.ConfiguracoesBuilder;
import br.com.virtualab.app.service.configuracoes.ConfiguracoesFactory;
import br.com.virtualab.app.service.principal.PrincipalFactory;
import br.com.virtualab.app.service.tema.TemaFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfiguracoesController extends AbstractController {

    /*inicio variaveis padrão sistema*/
    private static final long serialVersionUID = 1L;
    private boolean inicializado = false;
    private boolean acessoPermitidoTela = false;
    @Autowired
    private PrincipalFactory principalFactory;
    /*fim variaveis padrão sistema*/

    private Configuracoes configuracoes;
    private Configuracoes configuracoesSize;

    @Autowired
    private ConfiguracoesFactory configuracoesFactory;

    @Autowired
    private ConfiguracoesBuilder configuracoesBuilder;

    @Autowired
    private PrincipalController principalController;

    @Autowired
    private TemaFactory temaFactory;

    /*inicio padrão sistema*/
    public void inicializar() {
        if (inicializado == false) {
            novoObjSize();
            carregarObj(configuracoesFactory.buscarConfiguracoesPorId(Long.valueOf(1)));
            if (configuracoes == null) {
                novoObj();
            }
            acessoPermitidoTela = principalFactory.isPermitirAcessoUsuario(getPermissaoPerfil());
            inicializado = true;
        }
    }

    public String getPermissaoPerfil() {
        return Permissoes.CONFIGURACOES.name();
    }

    public boolean isAcessoPermitidoTela() {
        return acessoPermitidoTela;
    }

    public void novoObj() {
        configuracoes = new Configuracoes();
    }

    private void novoObjSize() {
        configuracoesSize = new Configuracoes();
    }

    public void carregarObj(Configuracoes configuracoes) {
        this.configuracoes = configuracoes;
    }
    /*fim padrão sistema*/

    public void salvar() {
        try {
            principalController.setTemaSistema(configuracoes.getTemaSistema());
            configuracoesBuilder.build(configuracoes);
            Long id = configuracoes.getId();
            novoObj();
            carregarObj(configuracoesFactory.buscarConfiguracoesPorId(id));
            setMessageGrowl("Configurações salva com sucesso!");
        } catch (Exception e) {
            tratarErro(e);
        }
    }

    public Configuracoes getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(Configuracoes configuracoes) {
        this.configuracoes = configuracoes;
    }

    public Configuracoes getConfiguracoesSize() {
        return configuracoesSize;
    }

    public TemaFactory getTemaFactory() {
        return temaFactory;
    }

    public void temaDefault() {
        configuracoes.setTemaSistema("aristo");
        principalController.setTemaSistema(configuracoes.getTemaSistema());
    }

}
