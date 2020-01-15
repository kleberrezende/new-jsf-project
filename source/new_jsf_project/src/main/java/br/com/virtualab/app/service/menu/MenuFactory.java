package br.com.virtualab.app.service.menu;

import br.com.virtualab.app.entity.menu.MenuGrupo;
import br.com.virtualab.app.entity.menu.MenuItem;
import br.com.virtualab.app.permissoes.Permissoes;
import java.util.ArrayList;
import java.util.List;

public class MenuFactory extends AbstractMenuFactory {

    private static final long serialVersionUID = 1L;

    @Override
    public List<MenuGrupo> inicializarMenu() {
        logger.debug("Inicializar Menu ...");
        List<MenuGrupo> menuGrupos = new ArrayList<MenuGrupo>();

        List<MenuItem> menuItens = new ArrayList<MenuItem>();
        addMenuGrupo(menuGrupos, menuItens, "Favoritos", "favoritos", true);

        menuItens = new ArrayList<MenuItem>();
        addMenuItem(menuItens, "principal", "Início", "ui-icon-home", "pages_principal", "principal,home,inicio", true, true);
        addMenuItem(menuItens, "alterarSenha", "Alterar senha", "ui-icon-newwin", "pages_alterarSenha", "alterar,senha", true, true);
        addMenuGrupo(menuGrupos, menuItens, "Geral", "geral", true);

        menuItens = new ArrayList<MenuItem>();
        addMenuItem(menuItens, "configuracoes", "Configurações", "ui-icon-gear", "pages_admin_cad_configuracoes", "configuracoes", true, Permissoes.CONFIGURACOES);
        addMenuItem(menuItens, "configuracoesWizard", "Configurações Wizard", "ui-icon-gear", "pages_admin_cad_configuracoesWizard", "configuracoes,wizard", true, Permissoes.CONFIGURACOES);
        addMenuItem(menuItens, "cadastroUsuario", "Usuário", "ui-icon-newwin", "pages_admin_cad_cadastroUsuario", "usuario", true, Permissoes.CADASTRO_USUARIO);
        addMenuGrupo(menuGrupos, menuItens, "Admin", "administrador", true);

        return menuGrupos;
    }

}
