import trainer

generations = 2500
population_size = 50
crossover_rate = 0.05
heuristic_mutate_rate = 0.05
inversion_mutate_rate = 0.05
depot_move_mutate_rate = 0
best_insertion_mutate_rate = 0.1
route_merge_rate = 0.05

if __name__ == '__main__':
    current_problem = 'p01'
    trainer.load_problem('../data/' + current_problem)
    trainer.set_population_size(population_size)
    trainer.initialize()
    best_solution = trainer.train(generations, crossover_rate, heuristic_mutate_rate, inversion_mutate_rate,
                                  depot_move_mutate_rate, best_insertion_mutate_rate, route_merge_rate,
                                  intermediate_plots=True)

    # for i in range(15, 24):
    #     if i < 10:
    #         n = '0' + str(i)
    #     else:
    #         n = str(i)
    #     print('p' + n)
    #     trainer.load_problem('../data/p' + n)
    #     trainer.set_population_size(population_size)
    #     trainer.initialize()
    #     best_solution = trainer.train(generations, crossover_rate, heuristic_mutate_rate, inversion_mutate_rate,
    #                                   depot_move_mutate_rate, best_insertion_mutate_rate, intermediate_plots=True, log=True)
    #
    #     if best_solution:
    #         trainer.save_solution(best_solution, '../solutions/p' + n)
