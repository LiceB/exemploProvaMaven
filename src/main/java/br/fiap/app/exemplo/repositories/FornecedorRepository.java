package br.fiap.app.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.app.exemplo.models.Fornecedor;
import br.fiap.app.exemplo.models.Produto;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
