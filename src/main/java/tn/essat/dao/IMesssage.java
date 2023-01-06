package tn.essat.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.Model.Message;
@Repository
public interface IMesssage extends JpaRepository<Message, Integer> {
@Query("select m from Message m where m.usersend.id=:x")
public List<Message>getAllMessageSend(@Param("x") int id);
@Query("select m from Message m where m.userreceive.id=:x")
public List<Message>getAllMessageReceives(@Param("x") int id);
}
