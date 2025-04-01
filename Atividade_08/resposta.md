# Documentação - Fase 1: Gerenciamento de Plantas no Sistema XYZ

## 1. História de Usuário

**Título:** Gerenciamento de Plantas - Fase 1

**Como** um usuário do sistema XYZ,  
**Quero** poder cadastrar, editar, excluir (somente se for administrador) e buscar informações sobre plantas,  
**Para que** eu possa manter os dados atualizados e organizados para uso nas próximas fases do projeto.

### Critérios de Aceite

- O sistema deve permitir a criação de plantas com código numérico único e obrigatório.
- A descrição da planta é opcional e deve aceitar até 10 caracteres alfanuméricos.
- Somente usuários com perfil de administrador podem excluir plantas.
- Não deve ser possível cadastrar duas plantas com o mesmo código.
- A funcionalidade de busca deve permitir filtrar plantas por código ou descrição.

---

## 2. Regras de Negócio e Suposições

- Cada planta deve ter um **código exclusivo** dentro do sistema.
- O **código é obrigatório** e **somente números** são permitidos.
- A **descrição é opcional**, limitada a 10 caracteres, podendo conter letras e números.
- **Somente usuários com permissão de administrador** podem excluir registros de planta.
- Supõe-se que o sistema já possui um controle de usuários com perfis definidos (admin, comum, etc).
- O sistema validará essas regras **antes de persistir os dados no banco**.

---

## 3. Validações e Medidas de Segurança

### Validações

- **Código**:
  - Obrigatório
  - Numérico
  - Único no sistema
- **Descrição**:
  - Opcional
  - Alfanumérica
  - Máximo de 10 caracteres

### Segurança

- Verificação do perfil do usuário (admin ou não) antes de permitir a exclusão.
- Logs de auditoria para operações de exclusão (quem excluiu, quando e qual planta).
- Proteção contra requisições não autorizadas utilizando autenticação e autorização (ex: JWT, OAuth2).

---

## 4. Estratégia de Testes (incluindo edge cases)

### Testes Positivos

- ✅ Cadastrar uma planta com código único e descrição válida.
- ✅ Cadastrar uma planta com código único e sem descrição.
- ✅ Editar a descrição de uma planta existente.
- ✅ Buscar plantas por código e por parte da descrição.
- ✅ Excluir uma planta como usuário administrador.

### Testes Negativos e Casos Limite (Edge Cases)

- ❌ Tentar cadastrar uma planta com código já existente.
- ❌ Informar letras ou símbolos no campo "código".
- ❌ Informar uma descrição com mais de 10 caracteres.
- ❌ Tentar excluir uma planta com um usuário que não seja administrador.
- ❌ Tentar excluir uma planta inexistente.
- ❌ Inserir um código muito grande (ex: mais de 10 dígitos) para validar limites.
- ❌ Testar cadastro com campos vazios.
