package br.com.virtualab.app.repository.configuracoes.impl;

import br.com.virtualab.app.entity.Abstract.AbstractEntity;
import br.com.virtualab.app.entity.configuracoes.Configuracoes;
import br.com.virtualab.app.entity.configuracoes.QConfiguracoes;
import br.com.virtualab.app.repository.Abstract.AbstractRepository;
import br.com.virtualab.app.repository.configuracoes.ConfiguracoesRepository;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.transaction.annotation.Transactional;

public class ConfiguracoesRepositoryImpl extends AbstractRepository implements ConfiguracoesRepository {

    private static final long serialVersionUID = 1L;

    @Override
    @Transactional(readOnly = false)
    public void save(Configuracoes configuracoes) {
        try {
            setAlteracao((AbstractEntity) configuracoes);
            if (configuracoes.getId() == null) {
                getEntityManager().persist(configuracoes);
            } else {
                getEntityManager().merge(configuracoes);
            }
        } catch (Exception e) {
            tratarErro(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Configuracoes buscarConfiguracoesPorId(Long id) {
        JPAQuery query = new JPAQuery(getEntityManager());
        QConfiguracoes qConfiguracoes = QConfiguracoes.configuracoes;
        query.from(qConfiguracoes).where(qConfiguracoes.id.eq(id));
        return query.uniqueResult(qConfiguracoes);
    }

}
