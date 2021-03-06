/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.jraft.rpc.impl.cli;

import java.util.concurrent.Future;

import com.alipay.sofa.jraft.option.CliOptions;
import com.alipay.sofa.jraft.option.RpcOptions;
import com.alipay.sofa.jraft.rpc.CliClientService;
import com.alipay.sofa.jraft.rpc.CliRequests;
import com.alipay.sofa.jraft.rpc.CliRequests.AddPeerRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.AddPeerResponse;
import com.alipay.sofa.jraft.rpc.CliRequests.ChangePeersRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.ChangePeersResponse;
import com.alipay.sofa.jraft.rpc.CliRequests.GetLeaderRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.GetLeaderResponse;
import com.alipay.sofa.jraft.rpc.CliRequests.RemovePeerRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.RemovePeerResponse;
import com.alipay.sofa.jraft.rpc.CliRequests.ResetPeerRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.SnapshotRequest;
import com.alipay.sofa.jraft.rpc.CliRequests.TransferLeaderRequest;
import com.alipay.sofa.jraft.rpc.RpcRequests.ErrorResponse;
import com.alipay.sofa.jraft.rpc.RpcResponseClosure;
import com.alipay.sofa.jraft.rpc.impl.AbstractBoltClientService;
import com.alipay.sofa.jraft.util.Endpoint;
import com.google.protobuf.Message;

/**
 * 
 * @author boyan (boyan@alibaba-inc.com)
 *
 * 2018-Apr-09 3:14:55 PM
 */
public class BoltCliClientService extends AbstractBoltClientService implements CliClientService {

    private CliOptions cliOptions;

    @Override
    public synchronized boolean init(RpcOptions rpcOptions) {
        boolean ret = super.init(rpcOptions);
        if (ret) {
            cliOptions = (CliOptions) this.rpcOptions;
        }
        return ret;
    }

    @Override
    public Future<Message> addPeer(Endpoint endpoint, AddPeerRequest request, RpcResponseClosure<AddPeerResponse> done) {

        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> removePeer(Endpoint endpoint, RemovePeerRequest request,
                                      RpcResponseClosure<RemovePeerResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> resetPeer(Endpoint endpoint, ResetPeerRequest request, RpcResponseClosure<ErrorResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> snapshot(Endpoint endpoint, SnapshotRequest request, RpcResponseClosure<ErrorResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> changePeers(Endpoint endpoint, ChangePeersRequest request,
                                       RpcResponseClosure<ChangePeersResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> getLeader(Endpoint endpoint, GetLeaderRequest request,
                                     RpcResponseClosure<GetLeaderResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> transferLeader(Endpoint endpoint, TransferLeaderRequest request,
                                          RpcResponseClosure<ErrorResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }

    @Override
    public Future<Message> getPeers(Endpoint endpoint, CliRequests.GetPeersRequest request,
                                    RpcResponseClosure<CliRequests.GetPeersResponse> done) {
        return this.invokeWithDone(endpoint, request, done, this.cliOptions.getTimeoutMs());
    }
}
