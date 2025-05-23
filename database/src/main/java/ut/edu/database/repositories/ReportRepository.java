package ut.edu.database.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ut.edu.database.enums.ReportStatus;
import ut.edu.database.models.Report;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByPropertyId(Long propertyId);
    List<Report> findByStartDateBetween(LocalDate start, LocalDate end);
    List<Report> findByStatus(ReportStatus status);
}
