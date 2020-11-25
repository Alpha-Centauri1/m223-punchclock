package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EntryRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EntryRepository entryRepository;

    String start = "2020-01-01 08:30";
    String end = "2020-01-01 16:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime checkIn = LocalDateTime.parse(start, formatter);
    LocalDateTime checkOut = LocalDateTime.parse(end, formatter);

    @Test
    public void whenFindAll_thenReturnAllEntries() {
        // given
        Entry entry = new Entry();
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);
        entityManager.persist(entry);
        entityManager.flush();

        // when
        List<Entry> found = entryRepository.findAll();

        // then
        assertThat(found.size()).isEqualTo(1);
    }

    @Test
    public void whenCreate_thenReturnEntry() {
        // given
        Entry entry = new Entry();
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);
        entityManager.persist(entry);
        entityManager.flush();

        // when
        Entry created = entryRepository.saveAndFlush(entry);

        // then
        assertThat(created).isEqualTo(entry);
    }

    @Test
    public void whenDelete_thenRemoveEntry() {
        // given
        Entry entry = new Entry();
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);
        entry.setId(1L);
        entityManager.persist(entry);
        entityManager.flush();

        // when
        entryRepository.deleteById(entry.getId());
        List<Entry> found = entryRepository.findAll();

        // then
        assertThat(found.size()).isEqualTo(0);
    }
}
