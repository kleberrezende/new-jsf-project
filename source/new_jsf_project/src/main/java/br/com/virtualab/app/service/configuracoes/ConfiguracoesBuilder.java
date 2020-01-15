package br.com.virtualab.app.service.configuracoes;

import br.com.virtualab.app.entity.configuracoes.Configuracoes;
import br.com.virtualab.app.repository.configuracoes.ConfiguracoesRepository;
import br.com.virtualab.app.service.Abstract.AbstractService;
import br.com.virtualab.utils.VirtualabResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ConfiguracoesBuilder extends AbstractService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ConfiguracoesRepository configuracoesRepository;

    public void build(Configuracoes configuracoes) {
        try {
            validarConfiguracoes(configuracoes);
            configuracoesRepository.save(configuracoes);
        } catch (Exception e) {
            tratarErro(e);
        }
    }
	
    private void validarConfiguracoes(Configuracoes configuracoes) {
        Assert.notNull(configuracoes, VirtualabResourceBundle.getMessage("controller.entidadeInvalida", "Configurações"));
        Assert.isTrue((configuracoes.getId() == null || configuracoes.getId() == 1), "Campo id não pode ser diferente de 1.");
        Assert.hasText(configuracoes.getTemaSistema(), "Campo tema não pode ser vazio.");
    }
    
}
