package org.zhxie.sprinpoker.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.zhxie.sprinpoker.domain.TicketRecord;

import java.time.LocalDate;

public interface ITicketRecordDAO extends JpaRepository<TicketRecord, Integer> , JpaSpecificationExecutor<TicketRecord> {

    Page<TicketRecord> findByTicketNumIgnoreCase(String tickerNum, Pageable pageable);

    Page<TicketRecord> findByDate(LocalDate date, Pageable pageable);

    Page<TicketRecord> findByTicketNumIgnoreCaseAndDate(String tickerNum, LocalDate date, Pageable pageable);

}
