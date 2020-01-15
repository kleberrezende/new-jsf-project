package br.com.virtualab.app.service.configuracoes;

import br.com.virtualab.app.entity.configuracoes.Configuracoes;
import br.com.virtualab.app.repository.configuracoes.ConfiguracoesRepository;
import br.com.virtualab.app.service.Abstract.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfiguracoesFactory extends AbstractService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ConfiguracoesRepository configuracoesRepository;
    
    public Configuracoes buscarConfiguracoesPorId(Long id) {
        return configuracoesRepository.buscarConfiguracoesPorId(id);
    }
    
}
