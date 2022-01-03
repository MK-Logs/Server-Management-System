package PortfolioProjects.server.service.implementation;

import PortfolioProjects.server.enumeration.Status;
import PortfolioProjects.server.model.Server;
import PortfolioProjects.server.repo.ServerRepo;
import PortfolioProjects.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static java.lang.Boolean.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {

        log.info("Saving New Server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);

    }

    @Override
    public Server ping(String ipAddress) throws IOException {

        log.info("Pinging Server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return null;

    }

    @Override
    public Collection<Server> list(int limit) {

        log.info("Fetching All Servers");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();

    }

    @Override
    public Server get(Long id) {

        log.info("Fetching Server By ID: {}", id);
        return serverRepo.findById(id).get();

    }

    @Override
    public Server update(Server server) {

        log.info("Updating Server: {}", server.getName());
        return serverRepo.save(server);

    }

    @Override
    public Boolean delete(Long id) {

        log.info("Deleting Server By ID: {}", id);
        serverRepo.deleteById(id);
        return TRUE;

    }

    private String setServerImageUrl() {

        return null;

    }

}
