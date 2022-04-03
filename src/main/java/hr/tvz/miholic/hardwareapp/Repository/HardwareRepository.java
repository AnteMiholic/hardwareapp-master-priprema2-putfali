package hr.tvz.miholic.hardwareapp.Repository;

import hr.tvz.miholic.hardwareapp.Classes.Hardware;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface HardwareRepository {

    Optional<Hardware> save(Hardware hardware);


    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    List<Hardware> findByType(String type);
}
