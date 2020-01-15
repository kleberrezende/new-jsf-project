package br.com.virtualab.app.repository.configuracoes;

import br.com.virtualab.app.entity.configuracoes.Configuracoes;

public interface ConfiguracoesRepository {

    void save(Configuracoes configuracoes);

    Configuracoes buscarConfiguracoesPorId(Long id);
    
}
